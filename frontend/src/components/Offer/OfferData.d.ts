interface OfferResponse {
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

interface OfferRequest {
  firstname: string;
  lastname: string;
  specializationId: number;
  content: string;
  createdAt: string; // ISO 8601 yyyy-mm-ddThh:mm:ss
}
