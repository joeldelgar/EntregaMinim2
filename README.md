# EntregaMinim2
L’aplicació a implementar ha de mostrar la informació bàsica d’un usuari de GitHub. Aquesta aplicació tindrà dos pantalles. La primera pantalla permetrà
introduir el nom de l’usuari i una segona pantalla mostrará les dades de l'usuari (imatge, nom de l’usuari, nombre de “followers” i “followings”) i els seus
repositoris (nom i llenguatge). El nom de l’usuari es guardarà a les preferències compartides (Shared Preferences) i en futures execucions de l’aplicació
apareixerà cumplimentat el camp de text. Per fer La informació de l’usuari es descarregarà utilitzant l’API pública de GitHub Developers (https://developer.github.com/v3/).

1.- Aquesta aplicació està pensada per visualitzar-se només en manera retrat (portrait)

2.- S’ha d’utilitzar obligatòriament la llibreria Retrofit, OkHttp i recyclerView pel llistat de repositoris

3.- S’ha d’afegir un progressbar (loader / “Cargando”) mentre es realitza la consulta al servidor.

4.- S’ha de mostrar una pantalla d’error. Per exemple, si no hi ha connectivitat o si l’usuari no existeix a github

5.- Per mostrar la imatge de l’usuari podeu utilitzar llibreries de tercers: Picasso, Glide o Frescos.
