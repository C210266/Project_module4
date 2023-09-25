

let products = JSON.parse(localStorage.getItem("products"))||[];
let categories = JSON.parse(localStorage.getItem("categories"))||[];
// {id:, name:, imageUrl:[] ,description: ,createDate:,price:,status:,category_id:}

// hiển thị
// let str ="hung";
// console.log('====================================');
// console.log(str.substring(0,3));
// console.log('====================================');
// taoj danh sachs danh mucj
let listCategory = "";
for (let i=0;i<categories.length;i++) {
    let element = categories[i];
    listCategory+= `<option value="${element.id}">${element.name}</option>`
}
document.getElementById("category").innerHTML= listCategory;

function showAllProducts (){
    let string ="";
    for (let i = 0; i < products.length; i++) {
        const element = products[i];
        string += `<tr>
        <td>${i+1}</td>
        <td>${element.name}</td>
        <td><img src="${element.imageUrl}" width="100px" alt="${element.name}"></td>
        <td>${element.description.substring(0,30)}...</td>
        <td>${element.createdDate}</td>
        <td>${element.price} $</td>
        <td>${element.status?"Ban":"Khong ban"}</td>
        <td>${findCategoryById(element.category_id).name}</td>
        <td>
            <button type="button" class="btn btn-warning">Edit</button>
        </td>
        <td>
            <button type="button" class="btn btn-danger">Delete</button>
        </td>
    </tr>`
    }

    document.getElementById("products").innerHTML = string;
}
showAllProducts();
// thêm mới

function addNewProduct() {
    let id =  getNewId();
    let name = document.getElementById("product_name").value;
    let imageUrl = getImage();
    console.log('====================================');
    console.log(imageUrl);
    console.log('====================================');
    let description = document.getElementById("description").value;
    let createdDate = new Date().toLocaleDateString();
    let price = document.getElementById("product_price").value;
    let status = document.getElementById("product_status").value ==="true";
    let category_id = document.getElementById("category").value;
    products.push({imageUrl,id,name,price,status,category_id,description,createdDate})
    localStorage.setItem("products",JSON.stringify(products));

    showAllProducts();
}
// hiển thị thông tin cần sửa 
function showEditPoduct(id) {
    
}

// cập nhật lại thông tin sau khi thay đổi
function handleUpdateProduct() {
    
}


// tìm kiếm theo id
function findById(id) {
    
}
// tim danh muc theo id
function findCategoryById(id) {
   return categories.find((cat)=>cat.id==id)
}

// xóa sản phẩm
function deleteProduct(id){

}

// tạo mới id tự tăng
function getNewId() {
    let idMax = 0;
    for (let i = 0; i < products.length; i++) {
        const element = products[i];
        if(idMax< element.id){
            idMax= element.id
        }
    }
    return idMax+1;
}