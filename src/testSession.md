Dans le navigateur (il garde le cookie JSESSIONID tout seul) :
``` bash
http://localhost:8080/app/api/session/me affiche « Personne n'est connecté ».
http://localhost:8080/app/api/session/login?username=rohan affiche « Connecté : alice ».
http://localhost:8080/app/api/session/me affiche « Utilisateur en session : alice ». Si c'est le cas, la recopie vers le HttpSession marche.
http://localhost:8080/app/api/session/logout, puis /me affiche de nouveau « Personne n'est connecté »
```

```bash
curl -c cookies.txt -b cookies.txt "http://localhost:8080/app/api/session/login?username=rohan"
curl -c cookies.txt -b cookies.txt "http://localhost:8080/app/api/session/me"

```