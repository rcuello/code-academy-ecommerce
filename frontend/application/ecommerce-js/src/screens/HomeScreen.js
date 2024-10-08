import data from "../mocks/data.js";

const HomeScreen = {
    render : async () => {
        //const {products} = data;

        const response = await fetch("http://localhost:9191/api/customer/products",{
            headers : {
                "Content-Type": "application/json"
            }
        });

        if(! response || !response.ok){
            return `<div>Error in getting data</div>`;
        }

        const products = await response.json().content;

        return `
        <ul class="products">
        ${products.map( product => `
            <li>
                <div class="product">
                    <a href="/#/product/${product._id}">
                        <img src="${product.image}" alt="${product.name}"/>
                    </a>
                    <div class="product-name">
                        <a href="/#/product/${product._id}">
                            ${product.name}
                        </a>
                    </div>
                    <div class="product-brand">
                        ${product.brand}
                    </div>
                    <div class="product-price">
                        $ ${product.price}
                    </div>
                </div>
            </li>
            `).join("\n")}
        </ul>`
    }
}

export default HomeScreen;