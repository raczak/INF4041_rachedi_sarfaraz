# INF4041_rachedi_sarfaraz - ESIEAdex
Le Pokédex sur votre téléphone !
# 
Allumez votre téléphone pour lancer l'application <strong>ESIEAdex</strong> et bénéficier d'une liste de Pokémons. Chacun d'entre eux affichera plusieurs statitiques comme le PC, PV, le poids et bien d'autres !
<br/>
Ils sont classés par générations. L'application affiche <strong>3 générations de Pokémons</strong>. 
<br/>
Chaque couleur des tab représente une génération précise de Pokémons (Version rouge Dracaufeu, Version bleu Tortank, Version jaune Pikachu)

# Une application vivante
Possédant un design propre aux applications Google, vous allez découvrir une application <strong>ergonomique</strong> et <strong>fluide</strong>.

# Les composants techniques
L'application est construite à l'aide des différents composants techniques attendus, c'est-à-dire, un <strong>RecyclerView</strong>, une <strong>actionbar</strong>, plusieurs activités ou encore un traitement de données JSON (via un fichier).
<br/><br/><br/>
D'autres composants non demandés par le professeur mais très compliqués à implémenter ont également été utilisés comme par exemple le <strong>TabLayout</strong>, <strong>l'IntentService</strong>, l'<strong>AsyncTask</strong>, <strong>ViewPager</strong> ainsi que l'utilisation des <strong>fragments</strong> (un fragment par tab).
<br/>
A noter que l'application intègre également un système de notification Android, qui peut s'afficher lors d'une mise à jour du fichier JSON depuis l'API.

# Guide pour vos tests (notation examinateur)
1 - Lancez l'application. <br/>
2 - Vous verrez alors un Launcher affichant le titre de l'application sur l'écran. <br/>
3 - Au démarrage l'application télécharge une première fois les fichiers JSON en back et signal la fin du téléchargement par une notification android. En cliquant sur la notification on est redirigé vers l'activité principale (liste de pokemon).</br>
4 - Vous tomberez ensuite sur la page principale de l'application, composant de trois colonnes (gen1, gen2, gen3) avec un fragment par tab.<br/>
5 - Chaque colonne contiendra des Pokémons, chargés à partir d'un fichier JSON.<br/>
6 - A noter qu'au lancement de l'application, un toast apparaît au milieu de l'écran.<br/>
7 - Si vous souhaitez visualiser l'action bar (avec les icons bouttons), il suffit de cliquer sur le "+" en bas à droite de l'application ce qui va vous rediriger vers une autre activité. <br/>
8 - Ensuite, un clic sur les boutons du menu de l'actionbar vous fera retourner sur la page principale, avec un toast.
