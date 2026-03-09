
let listCart = [];
function checkCart(){
        var cookieValue = document.cookie
        .split('; ')
        .find(row => row.startsWith('listCart='));
        if(cookieValue){
            listCart = JSON.parse(cookieValue.split('=')[1]);
        }
}
checkCart();
addCartToHTML();
function addCartToHTML(){
    // clear data default
    let listCartHTML = document.querySelector('.returnCart .list');
    listCartHTML.innerHTML = '';

    let totalQuantityHTML = document.querySelector('.totalQuantity');
    let totalpointsHTML = document.querySelector('.totalpoints');
    let totalQuantity = 0;
    let totalpoints = 0;
    // if has product in Cart
    if(listCart){
        listCart.forEach(product => {
            if(product){
                let newCart = document.createElement('div');
                newCart.classList.add('item');
                newCart.innerHTML = 
                    `<img src="${product.image}">
                    <div class="info">
                        <div class="name">${product.name}</div>
                        <div class="points">${product.points} Points /1 product</div>
                    </div>
                    <div class="quantity">${product.quantity}</div>
                    <div class="returnpoints">${product.points * product.quantity} Points</div>`;
                listCartHTML.appendChild(newCart);
                totalQuantity = totalQuantity + product.quantity;
                totalpoints = totalpoints + (product.points * product.quantity);
            }
        })
    }
    totalQuantityHTML.innerText = totalQuantity;
    totalpointsHTML.innerText = totalpoints;
}
