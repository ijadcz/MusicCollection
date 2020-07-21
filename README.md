# MusicCollection
Simple Spring app


Pod adresem http://localhost:8080/login 

Dla użytkownika o roli USER login i hasło user

Dla użytkownika o roli ADMIN login i hasło admin

Aplikacja testowana z wykorzystaniem rozszerzenia do Chrome: Tabbed Postman-REST Client


Dla admina:
- dodadnie piosenki do kolekcji http://localhost:8080/songs/add POST

{
        "title": "Parostatek",
        "artist": "Krzysztof Krawczyk"
    }
    
- usunięcie piosenki  http://localhost:8080/songs/id  DELETE
- modyfikacja piosenki http://localhost:8080/songs/id PUT

 {
        "id": id,
        "title": "Chciałem być",
        "artist": "Krzysztof Krawczyk"
    },
    
- wyświetlenie piosenki o wybranym id  http://localhost:8080/songs/id  GET


Dla usera:

- dodanie wybranej piosenki z kolekcji do swojej playlisty  http://localhost:8080/user/playlist/id PUT
- usunięcie piosenki z playlisty  http://localhost:8080/user/playlist/id DELETE
- wyświetlenie playlisty  localhost:8080/user/playlist GET


User i Admin:
- wyświetlenie wszystkich piosenek : http://localhost:8080/songs   GET

 






