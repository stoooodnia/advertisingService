interface OfferData {
  id: number;
  firstname: string;
  lastname: string;
  specialization: {
    id: number;
    label: string;
  };
  content: string;
  createdAt: string;
}
