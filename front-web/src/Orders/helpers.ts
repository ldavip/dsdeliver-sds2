import { Product } from './types';

export function isSelected(selectedProducts: Product[], product: Product): boolean {
    return selectedProducts.some(item => item.id === product.id);
}

export function formatPrice(price: number) {
    const formatter = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
        minimumFractionDigits: 2
    });

    return formatter.format(price)
}
