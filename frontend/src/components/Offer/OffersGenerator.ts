// Funkcja generująca losowy ciąg znaków
function generateRandomString(length: number) {
  let result = "";
  const characters =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  for (let i = 0; i < length; i++) {
    result += characters.charAt(Math.floor(Math.random() * characters.length));
  }
  return result;
}

// Funkcja generująca losową datę
function generateRandomDate(start: Date, end: Date) {
  return new Date(
    start.getTime() + Math.random() * (end.getTime() - start.getTime())
  );
}

// Generowanie 10 losowych ofert na podstawie danych z OffersMockData
const generatedOffers = [];
for (let i = 0; i < 10; i++) {
  const newOffer = {
    id: i + 1,
    firstname: generateRandomString(5),
    lastname: generateRandomString(7),
    specialization: generateRandomString(10),
    content: generateRandomString(20),
    createdAt: generateRandomDate(new Date(2021, 0, 1), new Date())
      .toISOString()
      .slice(0, 10),
  };
  generatedOffers.push(newOffer);
}

export default function generateOffers(count: number) {
  const generatedOffers = [];
  for (let i = 0; i < count; i++) {
    const newOffer = {
      id: i + 1,
      firstname: generateRandomString(5),
      lastname: generateRandomString(7),
      specialization: generateRandomString(10),
      content: generateRandomString(20),
      createdAt: generateRandomDate(new Date(2021, 0, 1), new Date())
        .toISOString()
        .slice(0, 10),
    };
    generatedOffers.push(newOffer);
  }
  return generatedOffers;
}
