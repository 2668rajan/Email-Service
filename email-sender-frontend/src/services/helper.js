import axios from "axios";

const baseURL = "http://localhost:8080/email";

export const customAxios = axios.create({
  baseURL: baseURL,
});
