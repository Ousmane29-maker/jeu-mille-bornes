# 🎮 Jeu de Mille Bornes

Implémentation complète en Java du célèbre jeu de cartes **Mille Bornes** avec système d'IA multi-niveaux et architecture orientée objet avancée.

## 📋 Description

Application Java développée en programmation orientée objet reproduisant fidèlement les règles du jeu Mille Bornes. Le projet implémente un système complet de gestion de parties avec plusieurs niveaux d'intelligence artificielle et une interface en ligne de commande.

---

## 🎯 Fonctionnalités Clés

### 🎴 Gestion Complète des Cartes
- **Cartes de Borne** : 25, 50, 75, 100, 200 km
- **Cartes d'Attaque** : Feu Rouge, Accident, Panne d'Essence, Crevaison
- **Cartes de Parade** : Feu Vert, Réparation, Essence, Roue de Secours
- **Cartes Botte** : Prioritaire, As du Volant, Citerne d'Essence, Increvable
- **Cartes Spéciales** : Limitation de Vitesse, Fin de Limitation
- **Import/Export** : Sauvegarde et chargement de paquets de cartes depuis fichiers texte

### 🤖 Intelligence Artificielle Multi-Niveaux
- **Stratégie Triviale** : Joue aléatoirement
- **Stratégie Basique** : Logique simple de jeu
- **Stratégie Facile** : IA améliorée avec prise de décision
- **Stratégie Difficile** : IA avancée avec évaluation des coups et anticipation
- **Interface en ligne de commande** avec couleurs ANSI pour une meilleure lisibilité

### 👥 Modes de Jeu
- Mode solo contre des bots (1 à 3 bots)
- Multi-joueurs (humains et/ou bots)
- Configuration flexible du nombre de joueurs
- Choix individuel de la stratégie pour chaque bot
- Distribution de **7 cartes** par joueur en début de partie

### 🏗️ Architecture Robuste
- Pattern **Strategy** pour les IA
- Pattern **Iterator** pour les collections
- Pattern **Factory** pour la création d'objets
- System de **clonage profond** pour la simulation de coups
- Gestion complète des **règles du jeu** (bottes, limitations, etc.)

---

## 🛠️ Technologies

| Composant | Technologie |
|-----------|-------------|
| **Langage** | Java |
| **Paradigme** | Programmation Orientée Objet |
| **IDE** | IntelliJ IDEA |
| **Design Patterns** | Strategy, Factory, Iterator, Singleton |

---

## 📂 Structure du Projet

```
JeuBPO/
├── src/
│   ├── cartes/              # Hiérarchie des cartes (Attaque, Parade, Botte, Bornes)
│   ├── joueurs/             # Joueur, JoueurHumain, Bot
│   ├── strategies/          # Stratégies d'IA (Triviale, Basique, Facile, Difficile)
│   ├── jeu/                 # Logique du jeu et gestion des parties
│   ├── collections/         # CollectionJoueurs, CollectionJeux, PaquetDeCartes
│   ├── fabriques/           # Factory (FabriqueCartes, FabriqueBottes, FabriqueJeux)
│   ├── dialogue/            # Interface ligne de commande
│   └── tests/               # Tests JUnit
├── ressources/              # Ressources du jeu
├── cartesTest.txt           # Fichier de test pour les paquets de cartes
└── README.md                # Documentation du projet
```

---

## 🏛️ Architecture UML

Le projet suit une architecture orientée objet stricte avec :

### Hiérarchie des Cartes
```
Carte (abstract)
├── Attaque (abstract)
│   ├── FeuRouge
│   ├── Accident
│   ├── PanneDEssence
│   └── Crevaison
├── Parade (abstract)
│   ├── FeuVert
│   ├── Reparation
│   ├── Essence
│   └── RoueDeSecours
├── Botte (abstract)
│   ├── Prioritaire
│   ├── AsDuVolant
│   ├── CiterneDEssence
│   └── Increvable
├── Bornes
├── LimitationDeVitesse
└── FinLimitationDeVitesse
```

### Pattern Strategy pour l'IA
```
Strategie (interface)
├── StrategieTrivial
├── StrategieBasique
├── StrategieFacile
└── StrategieDifficile
```

---

## 🚀 Installation & Lancement

### Prérequis
- **Java JDK 11** ou supérieur
- **IntelliJ IDEA** (recommandé) ou tout autre IDE Java

### Compilation en Ligne de Commande

```bash
# Clone le projet
git clone https://github.com/Ousmane29-maker/jeu-mille-bornes.git
cd jeu-mille-bornes

# Compile tous les fichiers Java
find src -name "*.java" > sources.txt
javac -d out @sources.txt

# Lance le jeu
java -cp out Main

```

### Avec IntelliJ IDEA

1. Ouvrir IntelliJ IDEA
2. File → Open → sélectionner le dossier du projet
3. Attendre l’indexation
4. Ouvrir la classe `Main`
5. Run → Run 'Main'

---

## 🎲 Règles du Jeu

### Objectif
Être le premier joueur à atteindre **1000 kilomètres** en posant des cartes Borne.

### Déroulement
1. Chaque joueur reçoit **7 cartes** en début de partie
2. À son tour, un joueur :
   - Peut poser une carte Borne (si aucune attaque active)
   - Peut attaquer un adversaire
   - Peut se défendre avec une Parade
   - Peut activer une Botte pour une immunité permanente
   - Doit piocher une carte (sauf si la pioche est vide)

### Cartes Spéciales
- **Bottes** : Immunités permanentes contre certaines attaques
- **Limitation de Vitesse** : Empêche de jouer des cartes 75, 100 et 200 km
- **Prioritaire** : Immunité contre Feu Rouge et Limitation de Vitesse

---

## 💻 Utilisation

### Format des Coups

```
J <indice>              # Jeter la carte d'indice <indice>
P <indice>              # Poser la carte d'indice <indice> sur son jeu
P <indice> <adversaire> # Poser la carte d'indice <indice> sur le jeu de l'adversaire
```

### Exemple de Partie

```
=== Bienvenue dans le Jeu Mille Bornes ===
=========================================
Entrez le nombre de bots (entre 1 et 3) : 1
Choisissez la stratégie pour Bot1 :
1. Facile
2. Difficile
> 1

=== 🌟 État du Jeu 🌟 ===
{
  nom = Bot1
  bornes = 0
  cartes200Jouees = 0
  bataille = Pas de bataille
  limitationVitesse = Pas de limitation de vitesse
  bottes = Aucune botte activée
}
🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟
{
  nom = JoueurHumain
  main = {FeuVert, FeuRouge, FeuRouge, FinLimitationDeVitesse, Bornes50, Essence, LimitationDeVitesse}
  bornes = 0
  cartes200Jouees = 0
  bataille = Pas de bataille
  limitationVitesse = Pas de limitation de vitesse
  bottes = Aucune botte activée
}

Veuillez saisir un coup possible :
> P21
# Pose FeuRouge (carte 2) sur Bot1 (joueur 1)

=== 🌟 État du Jeu 🌟 ===
{
  nom = Bot1
  bornes = 0
  bataille = FeuRouge (attaque active)
  bottes = Prioritaire (activée automatiquement)
}
...
```

---

## 🧪 Tests & Validation

Le projet inclut :
- **Tests JUnit** : Validation unitaire des composants
- **Import/Export de cartes** : Fichiers texte pour la persistence (`cartesTest.txt`)
- Factory de jeux de test (scénarios prédéfinis)
- Validation complète des règles du jeu
- Gestion des cas limites (pioche vide, fin de partie, etc.)
- Tests de régression pour les stratégies d'IA

### Format de fichier de cartes

Le système permet de sauvegarder et charger des paquets de cartes au format texte :

```
FeuVert 2
Bornes 75 1
Crevaison 2
Bornes 50 3
Accident 4
Bornes 100 2
FeuRouge 3
Increvable
Bornes 25 1
AsDuVolant
```

**Format** :
- `NomCarte Nombre` : Pour les cartes standards (ex: `FeuVert 2`)
- `Bornes KM Nombre` : Pour les cartes bornes (ex: `Bornes 75 1`)
- `NomBotte` : Pour les bottes (pas de nombre, ex: `Increvable`)

---

## 🎓 Concepts Avancés Implémentés

### Design Patterns
- **Strategy** : Différentes stratégies d'IA interchangeables
- **Factory** : Création standardisée de cartes, bottes et jeux
- **Iterator** : Parcours uniforme des collections
- **Template Method** : Classe abstraite Joueur avec spécialisations

### Techniques Avancées
- **Clonage profond** : Simulation de coups pour l'IA
- **Évaluation heuristique** : Calcul du meilleur coup (IA difficile)
- **Gestion d'état** : Bataille, Bottes, Limitations
- **Polymorphisme** : Hiérarchie des cartes et des joueurs
- **Sérialisation personnalisée** : Import/Export de paquets de cartes au format texte
- **Gestion d'exceptions** : ErreurFichier pour les opérations I/O

---

## 👤 Auteur

**Ousmane DIA**
Projet académique — Université de Lorraine
L2 Informatique — Module BPO (Bases de la Programmation Objet)

---

## 📄 Licence

Projet libre à des fins éducatives.

---

## 🔗 Liens Utiles

- [Règles officielles du Mille Bornes](https://assets.jumboplay.com/59025_Manual.pdf)
- [Documentation Java](https://docs.oracle.com/en/java/)

