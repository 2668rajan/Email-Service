import { customAxios } from "./helper";

export async function sendEmail(emailData) {
  const result = (await customAxios.post(`/send`, emailData)).data;
  return await result;
}
