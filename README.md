# Bienvenue à Statistic Diagram Generator

Il s'agit d'une application Java Swing qui génère un graphique à barres à partir des données d'un fichier Excel. L'utilisateur peut sélectionner un fichier Excel à l'aide d'une boîte de dialogue de sélection de fichiers, puis générer un graphique à barres à partir des données du fichier sélectionné.

## Exigences
Pour exécuter cette application, vous aurez besoin de:

 - Java Development Kit (JDK) version 8 ou supérieure
 - Maven version 3.6.0 ou supérieure
 - Apache POI version 3.17 ou supérieure
 - JFreeChart version 1.0.19 ou supérieure
## Installation
Clonez ce dépôt sur votre machine locale en exécutant la commande suivante dans votre terminal ou votre invite de commande:

```bash
git clone https://github.com/u-Aymane/IHM-Project-Statistics-Diagram
```

Accédez au répertoire cloné en exécutant la commande suivante:

```bash
cd IHM-Project
```
Compilez le projet en exécutant la commande suivante:

```python
mvn compile
```
## Utilisation
Exécutez l'application en exécutant la commande suivante dans le terminal ou l'invite de commande:

```bash
mvn exec:java -Dexec.mainClass="Main"
```
 - Cliquez sur le bouton "Charger un fichier Excel" pour sélectionner un fichier Excel à partir de votre système de fichiers.

 - Cliquez sur le bouton "Générer un diagramme" pour générer un diagramme à barres à partir des données du fichier Excel sélectionné.

## Développement

 - ExcelReader - cette classe lit les données à partir d'un fichier Excel et retourne une liste de valeurs pour une colonne spécifique. Elle utilise la bibliothèque Apache POI pour lire les données Excel.

 - DiagramGenerator - cette classe génère un diagramme à barres à partir d'une liste de valeurs en utilisant la bibliothèque JFreeChart.

 - MainWindow - cette classe crée l'interface utilisateur Swing pour l'application. Elle contient un bouton pour charger un fichier Excel et un bouton pour générer un diagramme à barres à partir des données du fichier Excel chargé. Elle utilise les classes ExcelReader et DiagramGenerator pour lire les données et générer le diagramme.

 - Main - cette classe lance l'application en créant une instance de la classe MainWindow et en l'affichant à l'écran.

Le flux de travail global de l'application est le suivant : l'utilisateur sélectionne un fichier Excel à partir de son système de fichiers à l'aide de l'interface utilisateur, l'application lit les données à partir du fichier Excel en utilisant la classe ExcelReader, puis génère un diagramme à barres à partir des données en utilisant la classe DiagramGenerator. Le diagramme est affiché à l'utilisateur dans l'interface utilisateur Swing de l'application.

## Description bref du code

ExcelReader.java - cette classe lit les données à partir d'un fichier Excel et retourne une liste de valeurs pour une colonne spécifique. Par exemple, si vous avez un fichier Excel avec une colonne de ventes, vous pouvez utiliser cette classe pour lire cette colonne et retourner une liste de valeurs de ventes. Voici un exemple d'utilisation de cette classe :

```java
ExcelReader excelReader = new ExcelReader("data.xlsx");
List<Double> salesData = excelReader.readDataFromColumn(0, 1);
```
Cet exemple lit le fichier data.xlsx et retourne une liste de valeurs pour la deuxième colonne (indice 1) de la première feuille (indice 0) du fichier.

 - DiagramGenerator.java - cette classe génère un diagramme à barres à partir d'une liste de valeurs. Par exemple, si vous avez une liste de ventes, vous pouvez utiliser cette classe pour générer un diagramme à barres montrant les ventes par mois. Voici un exemple d'utilisation de cette classe :

```java
DiagramGenerator diagramGenerator = new DiagramGenerator();
JFreeChart chart = diagramGenerator.createBarChart("Ventes par mois", "Mois", "Ventes", salesData);
```

Cet exemple crée une instance de DiagramGenerator, puis génère un diagramme à barres avec un titre "Ventes par mois", une étiquette d'axe X "Mois" et une étiquette d'axe Y "Ventes". Les données de vente sont passées à la méthode createBarChart pour générer le diagramme.

 - MainWindow.java - cette classe crée l'interface utilisateur Swing pour l'application. Elle contient un bouton pour charger un fichier Excel et un bouton pour générer un diagramme à barres à partir des données du fichier Excel chargé. Voici un exemple de création d'une instance de cette classe :

```java
MainWindow mainWindow = new MainWindow();
mainWindow.setVisible(true);
```
Cet exemple crée une instance de MainWindow et l'affiche à l'écran en utilisant la méthode setVisible.

 - Main.java - cette classe lance l'application en créant une instance de la classe MainWindow et en l'affichant à l'écran. Voici un exemple de lancement de l'application :

```java
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    });
}
```

Cet exemple utilise la méthode invokeLater de SwingUtilities pour créer et afficher l'interface utilisateur Swing de l'application dans un thread séparé.
