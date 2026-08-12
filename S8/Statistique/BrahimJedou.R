# Auteur : Cheikh Brahim Jedou



rm(list=ls())


library(MASS)

# Importation des données
data = read.table(file="DataTP4.txt", header=TRUE)
data$CouvTot = as.factor(data$CouvTot)


names(data)
summary(data)
dim(data)


###################################################################
# PARTIE 1 : 
###################################################################


x11()
boxplot(P60 ~ CouvTot, data=data, 
        main="Impact de la couverture nuageuse sur la production P60",
        xlab="Couverture nuageuse (A: Faible, B: Moyenne, C: Forte)", 
        ylab="Production P60 (W)", 
        col=c("gold", "orange", "gray"))

# 
test_lien = aov(P60 ~ CouvTot, data = data)
summary(test_lien)

#---  PARTIE 1 ---
# Le boxplot montre clairement que plus le ciel se couvre de nuages (de la catégorie A vers C), plus la production d'énergie photovoltaïque s'effondre.
# L'ANOVA confirme ce lien avec une p-value minuscule (p < 2e-16), ce qui prouve que ce décalage n'est pas dû au hasard.
# La couverture nuageux (CouvTot) est donc un excellent prédicteur qu'il faut absolument conserver pour nos modèles de prévision.


###################################################################
# PARTIE 2 : 
###################################################################


lmcomp = lm(P60 ~ ., data=data)
summary(lmcomp)

#--- COMMENTAIRES PARTIE 2 ---
# Performances du modèle complet : 
# - Le R2 ajusté est de 0.8414 : le modèle est excellent et explique 84,14% de la variance de la production photovoltaïque (P60).
# - T2M : Sa p-value (0.096) montre qu'elle n'est PAS significative au seuil de 5%. Son effet direct est ici masqué par les flux.
# - HautSoleil : Son coefficient est de +12.77 et ultra-significatif (p < 2e-16 ***). Plus le soleil est haut, plus la production augmente.
# Selection manuelle des prédicteurs à conserver (p < 0.05) : 
# - HautSoleil, HOUR, FLSOLAIRE_D, CAPE_INS, HU950 et CouvTot (B et C).


###################################################################
# PARTIE 3 : 
###################################################################


lmbic = stepAIC(lmcomp, k=log(nrow(data)), direction="backward", trace=FALSE)
summary(lmbic)


lm_max_int = lm(P60 ~ .^2, data=data)
lmbicint = stepAIC(lmbic, scope=list(upper=lm_max_int), k=log(nrow(data)), direction="forward", trace=FALSE)
summary(lmbicint)

# Dimensions des modèles
length(coef(lmcomp))
length(coef(lmbic))
length(coef(lmbicint))


lmint = stepAIC(lm(P60 ~ HautSoleil + FLSOLAIRE_D, data=data), 
                scope=list(upper=~(HautSoleil + FLSOLAIRE_D + CouvTot + T2M)^2), 
                k=log(nrow(data))*1.5, direction="forward", trace=FALSE)
summary(lmint)

#--- COMMENTAIRES PARTIE 3 ---
# L'algorithme automatique est plus performant et robuste qu'un choix humain, car il a pu détecter et éliminer les variables colinéaires (comme la température T2M ou la pression PMER) dont l'information était déjà captée par le flux solaire.
# La sélection automatique BIC a éliminé la température (T2M) et la pression (PMER), alors que nous les avions conservées manuellement à la question 2 car elles avaient une petite étoile .
#
# Le modèle lmbicint utilise 21 prédicteurs au total (dimension en forte hausse) :
# - L'introduction des interactions permet d'expliquer 87.54% de la variance (R2 augmente).
# - L'erreur standard des résidus baisse significativement et passe à 296.
# - L'interaction FLSOLAIRE_D:CouvTotC est négative et hautement significative : cela montre physiquement que l'effet du flux solaire au sol est fortement réduit en cas de ciel très nuageux. 
# - L'interaction HautSoleil:HOUR est positive et significative : l'effet de l'heure sur la production dépend directement de la hauteur du soleil dans le ciel.
#
# Le modèle lmint utilise 7 prédicteurs au total (dimension inférieure à 8 respectée) :
# - Malgré sa petite taille, il explique 84.34% de la variance (R2 ajusté très satisfaisant).
# - L'erreur standard des résidus remonte légèrement à 331.9 par rapport au modèle complet.
# - L'algorithme a choisi d'inclure la variable qualitative CouvTot et ses interactions avec le flux.
# - Les interactions FLSOLAIR_D:CouvTotB et FLSOLAIRE_D:CouvTotC sont négatives et ultra-significatives : cela confirme de façon simple que la couverture nuageuse réduit directement l'efficacité du flux solaire.


###################################################################
# PARTIE 4 : 
###################################################################


x11()
plot(data$P60[1:200], type="l", lwd=2, 
     main="Prévisions sur les 200 premières heures", xlab="Heures", ylab="P60 (W)")
points(predict(lmbic)[1:200], col="blue", pch="+")
points(predict(lmbicint)[1:200], col="red", pch="*")

#--- PARTIE 4 ---
# La courbe noire montre la forte cyclicité journalière de la production (pics le jour, zéros la nuit).
# Le modèle lmbic (plus simple, croix bleues) a tendance à sous-estimer certains pics de forte production.
# Le modèle lmbicint (avec interactions, étoiles rouges) épouse beaucoup mieux les sommets des vagues.
# Conclusion : l'ajout des interactions dans lmbicint permet de mieux capturer les variations extrêmes.


###################################################################
# PARTIE 5 : 
###################################################################

source("CV.R")



# En apprentissage (bleu), le modèle bicint (avec interactions) donne la RMSE la plus faible (autour de 290).
# En test (rouge), le modèle bicint reste le plus performant avec la boîte la plus basse (autour de 300).
# Les boîtes rouges (test) ne remontent pas de manière excessive par rapport aux boîtes bleues (apprentissage).
# Conclusion : Aucun modèle ne souffre de sur-apprentissage critique, et lmbicint reste le meilleur choix final.

############################ 
#Partie 6 
 ############################
data$Seuil1500=as.factor(as.numeric(data$P60>1500))
glm_comp=glm(Seuil1500~.,data=data[,-1],family=binomial) 
summary(glm_comp)
glm_bic=stepAIC(glm_comp,k=log(nrow(data)),direction="backward",trace=FALSE) 
summary(glm_bic)
source("scores.R")
scores(predict(glm_bic,type="response")>0.5,data$Seuil1500)
scores(predict(glm_bic,type="response")>0.65,data$Seuil1500)

###################################################################
# PARTIE 6 :
# Avec le seuil de 0.5 :
# Le taux global est de 92.4% et le PSS est de 0.78.
# On detecte bien le depassement (H = 82.4%) avec tres peu de fausses alarmes (F = 4.3%).
#le modele logistique discrimine tres bien les fortess productions sans alerter pour rien 





 
 
 
 
 
 