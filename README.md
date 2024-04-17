# ProjetDevOps

## GRAF DataFrame: meilleur qu'Excel
| | |
| --- | --- |
| Testing | [![CI - Test](https://github.com/Bylack26/ProjetDevOps/actions/workflows/pipeline.yml/badge.svg)](https://github.com/ProjetDevOps/actions/workflows/pipeline.yml) |
| Lien | [![Notre site web](https://img.shields.io/badge/lien_vers_notre_site-GRAF_DataFrame-blue)](https://bylack26.github.io/ProjetDevOps/) |

## Ligne de commande pour Jacoco
mvn clean org.jacoco:jacoco-maven-plugin:0.8.8:prepare-agent  verify org.jacoco:jacoco-maven-plugin:0.8.8:report


# Documentation

## Dataframe:
- Dataframe(List<String> labels, List<Column> datas) : Construit un dataframe à partir des **labels** du dataframe et dont les données sont contenues **data**. Si les colonnes ne sont pas de taille égales, du padding complète les colonnes.
- Dataframe(String csvFilePath) : Construit un dataframe à partir d'un fichier **csvFilePath**. La première ligne du fichier contient les labels des colonnes et la suivante sert à inférer le type de la colonne.
- String displayAll() : renvoie un String du dataframe dans son intégralité, labels et données compris.
- String display(int ligne) : renvoie un String de la **ligne** passé en paramètre du dataframe.
- String displayHeader() : renvoie un String contenant les labels du dataframe.
- List<String> getNames() : renvoie une List contenant les labels du dataframe.
- List<Column> getData() : renvoie une List<Column> contenant les colonnes du dataframe.

## Column:
- Column<T>(Types type) : Construit une colonne de Types **type**.
- Column<T>() : Construit une colonne sans préciser son Types.
- T getValue(int i): renvoie la valeur de la ligne **i** de la colonne
- void add(T elm): Ajoute un élément à la colonne. Si le Types n'est pas encore connu il est déterminé par le premier élément ajouté.
- Types getType(): renvoie le Types de la colonne
- int length(): renvoie la longueur de la colonne
- Column<T> split(List<Integer> indices): renvoie une nouvelle Column à partir des lignes données par les **indices**.
- Column<T> split(int i, int j) : renvoie une nouvelle Column à partir de l'index **i** jusqu'à l'index **j**.

## Selector:
- static Dataframe selectRows(DataFrame dataframe, List<Integer> indices): renvoie un nouveau dataframe contenant les labels du **dataframe** d'origine et n'ayant que les lignes dont les **indices** sont passés en paramètre.
- static DataFrame selectRows(DataFrame dataframe, int rangeStart, int rangeEnd) : renvoie un nouveau dataframe contenant les labels du **dataframe** d'origine et n'ayant que les lignes dont les indices sont contenus entre **rangeStart** et **rangeEnd**.
- static DataFrame selectCols(DataFrame dataframe, List<String> labels): renvoie un nouveau dataframe contenant les colonnes dont les **labels** sont passés en paramètres.

## Statistics:
- static float mean(Column c) : calcule la moyenne des valeurs de la **colonne** passée en paramètre si cette dernière n'est pas de type String.

# Choix des outils : 
- Github : Choix de la platerforme Github pour déposer notre projet, par facilité puisque nous connaissions tous la plateforme.
- Jacoco : Choix de l'outil Jacoco pour la couverture de code, 
- JUnit : Choix de l'outil JUnit 5 pour l'automatisation des tests,
- Docker : Choix de docker pour la mise en place d'images permettant l'éxécution d'un petit script de démonstration.

Les choix décrit précédemment ont été dans le but d'automatiser et d'améliorer les déploiements des versions du projet.
D'un point de vue organisation l'utilisation d'un service tel que Github permet de gérer de manière claire et versionnée, l'avancement du projet.
Ainsi le travail peut être aisément séparé comme nous le détaillerons plus tard grâce à notre Workflow Git.
La mise en place d'images Docker est quant à elle une première étape, permettant à terme d'améliorer la qualité du code en nous permettant de le tester sur diverses architectures, dans des conditions variés, etc...
Dans l'état actuel des choses nous pouvons commencer à voir les possiblités qui nous sont offertes avec l'image de démonstration généré par le dockerfile.

Ensuite viennent les outils JaCoCo et JUnit, respectivement pour la couverture de code et les tests. Ces deux outils permettent de faciliter et d'automatiser, via maven, la prise en charge des tests et les statisques sur la quantité de code couvert par nos tests.
Dans l'ensemble cela permet d'obtenir des informations sur la qualité du code et de traquer les erreurs ou les points à revoir.
L'utilisation de pipeline GitHub nous permet aussi d'utiliser ces tests pour refuser du code risquant de dégradé une branche plus importante (lors d'un merge vers la branche develop par exemple).
Ainsi tout code devra s'acquitter des tests avant de pouvoir être accepté. Il s'agit là d'une sécurité, pour éviter que le partage du travail ne déteriore la qualité du projet, lorsque des branches distinctes viennent à modifier le des aspects sensibles du projet.


## Workflow Git : 
Chaque nouvelle *feature* doit fait l'objet d'une nouvelle branche dérivant de la branche **develop**. Cette branche est utilisé comme branche principale au sein de l'équipe et n'est donc pas destiné aux utilisateurs.
Une fois les fonctionnalités implémentées les branches doivent passer les tests avant d'être poussées vers le dépot. La fusion de ces branches doit ensuite être soumise à une revu lors d'une *pull request*. Lorsque l'ensemble du projet semble être arrivé à un niveau d'implémentation satisfaisant il peut alors être fusionné vers la branche **main**, celle-ci à direction des utilisateurs. Dans le même temps une telle fusion va générer une image *docker* permettant de faire une petite démonstration de notre ***Dataframe***.
L'image docker est ensuite poussée vers un dépôt DockerHub : [https://hub.docker.com/repository/docker/bylack26/dev_ops/general](https://hub.docker.com/repository/docker/bylack26/dev_ops/general).
  
