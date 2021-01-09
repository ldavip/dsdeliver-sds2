import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { fetchProducts, saveOrder } from "../api";
import Footer from "../Footer";
import { isSelected } from "./helpers";
import OrderLocation from "./OrderLocation";
import OrderSummary from "./OrderSummary";
import ProductsList from "./ProductsList";
import StepsHeader from "./StepsHeader";
import { OrderLocationData, Product } from "./types";

function Orders() {

  const [products, setProducts] = useState<Product[]>([]);
  const [selectedProducts, setSelectedProducts] = useState<Product[]>([]);
  const [orderLocation, setOrderLocation] = useState<OrderLocationData>();
  const totalPrice = selectedProducts.reduce((sum, item) => sum + item.price, 0);

  useEffect(() => {
    fetchProducts()
      .then(response => setProducts(response.data))
      .catch(error => {
        console.error(error);
        toast.warning('Erro ao listar produtos');
      })
  }, [])

  const handleSelectProduct = (product: Product) => {
    if (isSelected(selectedProducts, product)) {
      const selected = selectedProducts.filter(item => item.id !== product.id);
      setSelectedProducts(selected);
    } else {
      setSelectedProducts(previous => [...previous, product]);
    }
  }

  const handleSubmit = () => {
    if (!selectedProducts.length) {
      toast.warning('Nenhum produto selecionado!');
      return;
    }

    if (!orderLocation?.address) {
      toast.warning('Endereço não informado!');
      return;
    }

    const productsIds = selectedProducts.map(({ id }) => ({ id }));
    const payload = {
      ...orderLocation!,
      products: productsIds
    }

    saveOrder(payload).then((response) => {
      toast.error(`Pedido enviado com sucesso! Nº ${response.data.id}`);
      setSelectedProducts([]);
    })
      .catch(() => {
        toast.warning('Erro ao enviar pedido');
      })
  }

  return (
    <>
      <div className="orders-container">
        <StepsHeader />
        <ProductsList
          products={products}
          onSelectProduct={product => handleSelectProduct(product)}
          selectedProducts={selectedProducts}
        />
        <OrderLocation
          onChangeLocation={location => setOrderLocation(location)}
        />
        <OrderSummary
          amount={selectedProducts.length}
          totalPrice={totalPrice}
          onSubmit={handleSubmit}
        />
      </div>
      <Footer />
    </>
  )
}

export default Orders;
