import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:8081/api/",
  headers: {
    "Content-Type": "application/json",
  },
});

export default {
  getOffersDefault() {
    return apiClient.get("offers");
  },
  getOffers(page: number, size: number) {
    return apiClient.get(`offers?page=${page}&size=${size}`);
  },
  postOffer(offer: OfferRequest) {
    return apiClient.post("offers", offer);
  },
  editOffer(offer: OfferRequest, id: number) {
    return apiClient.put(`offers/${id}`, offer);
  },
  deleteOffer(id: number) {
    return apiClient.delete(`offers/${id}`);
  },
};
