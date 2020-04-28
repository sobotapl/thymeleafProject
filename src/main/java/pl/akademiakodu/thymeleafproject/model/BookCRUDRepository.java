package pl.akademiakodu.thymeleafproject.model;

import org.springframework.data.repository.CrudRepository;

public interface BookCRUDRepository extends CrudRepository<Book, Long>{

    /*
count() - zliczailość rekordó w danym repozytorium (ilość rekordów w bazie danych)
delete(id) - usuwa rekord o wskazanym id
delete(Iterable) - usuwa z bazy danych encje zapisane w kolekcji przekazanej jako argument metody. Kolekcja powinna implementować interfejs Iterable.
delete(entity) - usuwa z repozytorium encję przekazaną jako argument
deleteAll() - usuwa z repozytorium wszystkie rekordy
exists(id) - sprawdza istnieje rekordu o wskazanym id w repozytorium
findAll() - zwraca kolekcję wszystkich obiektów w repozytorium
findAll(ids) - zwraca kolekcję obiektów, których id znalazło się w kolekcji przekazanej jako argument
findOne(id) - zwraca z repozytorium obiekt o wskazanym id
save(Iterable) - zapisuje w repozytorium wszystkie rekordy z kolekcji przekazanej jako argument
save(entity) - zapisuje w repozytorium pojedynczy obiekt

 */


}
