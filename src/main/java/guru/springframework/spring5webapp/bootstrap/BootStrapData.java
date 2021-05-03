package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author matteo = new Author("Matteo", "De Kerpel");
        Book bio = new Book("Matteo in 2 words", "123123");
        matteo.getBooks().add(bio);
        bio.getAuthors().add(matteo);

        authorRepository.save(matteo);
        bookRepository.save(bio);

        Author tony = new Author("Tony", "Macaroni");
        Book pastaBook = new Book("Italian Cooking", "134134");
        tony.getBooks().add(pastaBook);
        pastaBook.getAuthors().add(tony);

        authorRepository.save(tony);
        bookRepository.save(pastaBook);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
