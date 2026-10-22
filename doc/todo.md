Objectif : restreindre l'acces aux user non connecté (sprint 10)
- [x] creation d'une annotation pour dire que cette methode doit etre utiliser par un utilisateur connecté
- [ ] Pour la connexion:
  - [ ] mettre la variable que le cote app va utiliser pour identifier l'utilisateur dans une variable dans web.xml
  - [ ] le contextListener va le capturer et l'envoyer vers le frontServlet et le mettre dans une instance de MySession
- [ ] annoter les methodes d'actions dans le controller avec la nouvelle annotation 
- [ ] tester l'acces a ces fonctions lorsqu'on est pas connecté