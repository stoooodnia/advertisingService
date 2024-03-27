import axios from "axios";

const apiClient = axios.create({
  baseURL: process.env.API,
  headers: {
    "Content-Type": "application/json",
  },
});

export default {
  getOffers() {
    return apiClient.get("/offers");
  },
};
