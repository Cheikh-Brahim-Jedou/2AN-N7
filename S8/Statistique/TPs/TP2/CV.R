# TP2 HPC-BigData : script d'evaluation des modeles

library(MASS)

data=read.table(file="DataTP4.txt",header=TRUE)
data$CouvTot=as.factor(data$CouvTot)


RMSE=function(obs,pr){
return(sqrt(mean((pr-obs)^2)))}

# Choix automatique de predicteurs a partir du modele complet, sans puis avec interactions

form_bic = formula(lmbic) 
form_bicint = formula(lmbicint) 
form_int = formula(lmint)

k=100

tab=matrix(nrow=k,ncol=8)

for (i in 1:k) {

# Creation archives d'apprentissage et de test
nappr=round(0.7*nrow(data))
ii=sample(1:nrow(data),nappr)
datapp=data[ii,]
datatest=data[-ii,]

# Estimation des modeles
m_comp = lm(P60~., datapp) 
m_bic = lm(form_bic, datapp)
 m_bicint = lm(form_bicint, datapp)
 m_int = lm(form_int, datapp)
 # modele volontairement sur-apprenti (interactions d'ordre 3), sans selection automatique des predicteurs

# Scores sur apprentissage
tab[i,1]=RMSE(datapp$P60,predict(m_comp))
tab[i,2]=RMSE(datapp$P60,predict(m_bic))
tab[i,3]=RMSE(datapp$P60,predict(m_bicint))
tab[i,4]=RMSE(datapp$P60,predict(m_int))

# Scores sur test
tab[i,5]=RMSE(datatest$P60,predict(m_comp,datatest))
tab[i,6]=RMSE(datatest$P60,predict(m_bic,datatest))
tab[i,7]=RMSE(datatest$P60,predict(m_bicint,datatest))
tab[i,8]=RMSE(datatest$P60,predict(m_int,datatest))

}

x11() 
boxplot(tab, col=c(rep("blue",4), rep("red",4)), xlab="bleu=apprentissage - rouge=test", names=c("comp","bic","bicint","int","comp","bic","bicint","int"), main="Prevision Photovoltaique - Score RMSE")
