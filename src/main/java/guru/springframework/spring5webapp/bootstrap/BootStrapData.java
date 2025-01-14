package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author matteo = new Author("Matteo", "De Kerpel");
        Book bio = new Book("Matteo in 2 words", "123123");

        Publisher publisher1 = new Publisher("test", "test", "test", "test", 17474);
        publisherRepository.save(publisher1);
        System.out.println("Number of publishers: " + publisherRepository.count());

        matteo.getBooks().add(bio);
        bio.getAuthors().add(matteo);

        bio.setPublisher(publisher1);
        publisher1.getBooks().add(bio);

        authorRepository.save(matteo);
        bookRepository.save(bio);
        publisherRepository.save(publisher1);


        Author tony = new Author("Tony", "Macaroni");
        Book pastaBook = new Book("Italian Cooking", "134134");
        tony.getBooks().add(pastaBook);
        pastaBook.getAuthors().add(tony);

        pastaBook.setPublisher(publisher1);
        publisher1.getBooks().add(pastaBook);

        authorRepository.save(tony);
        bookRepository.save(pastaBook);
        publisherRepository.save(publisher1);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of published books: " + publisher1.getBooks().size());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
