const API_URL = 'https://ldavip-sds2.herokuapp.com';

import axios from "axios";

export function fetchOrders() {
    return axios(`${API_URL}/orders`);
}

export function confirmDelivery(orderId: number) {
    return axios.put(`${API_URL}/orders/${orderId}/delivered`);
}