INSERT INTO specialization (id, label)
VALUES
    (1, 'Chirurgia'),
    (2, 'Dermatologia'),
    (3, 'Laryngologia'),
    (4, 'Okulistyka'),
    (5, 'Ortopedia'),
    (6, 'Stomatologia'),
    (7, 'Neurologia'),
    (8, 'Internistyka'),
    (9, 'Pediatria'),
    (10, 'Psychiatria');

INSERT INTO offer (id, firstname, lastname, content, created_at, specialization_id)
VALUES
    (1, 'Jan', 'Kowalski', 'Szukam asystenta', '2021-10-10', 1),
    (2, 'Anna', 'Nowak', 'Zatrudnię asystenta na umowę o pracę!', '2021-10-10', 2),
    (3, 'Piotr', 'Wiśniewski', 'Zatrudnię asystenta', '2021-10-10', 3),
    (4, 'Katarzyna', 'Kowalczyk', 'Szukam asystenta', '2021-10-10', 4),
    (5, 'Mateusz', 'Zieliński', 'Zatrudnię specjalistę', '2021-10-10', 5),
    (6, 'Agnieszka', 'Wójcik', 'Poszukujemy stażysty', '2021-10-10', 6),
    (7, 'Michał', 'Kaczmarek', 'Nowa placówka poszukuje personelu', '2021-10-10', 7),
    (8, 'Karolina', 'Dąbrowska', 'Przyjmę asystenta na staż', '2021-10-10', 8),
    (9, 'Paweł', 'Grabowski', 'Szukam zastępstwa', '2021-10-10', 9),
    (10, 'Magdalena', 'Piotrowska', 'Zatrudnię psychiatrę', '2021-10-10', 10);