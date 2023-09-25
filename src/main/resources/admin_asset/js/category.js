<<<<<<< HEAD
// code logic của trang category

// let date = new Date();
// console.log(date.toLocaleDateString());

let categories = JSON.parse(localStorage.getItem("categories"))||[];
// chức năng hiển thị ra giao diện (READ)
function showListCategories() {
    let string ="";
    for (let i = 0; i < categories.length; i++) {
        const element = categories[i];
        string = string + `<tr>
        <td>${i+1}</td>
        <td>${element.name}</td>
        <td>${element.descriptions}
        </td>
        <td>${element.createdDate}</td>
        <td>
            <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#editModal"  onclick="getCategoryByid(${element.id})">Edit</button>
        </td>
        <td>
            <button type="button" class="btn btn-danger" onclick="deleteCategory(${element.id})">Delete</button>
        </td>
    </tr>`
    }

    // chèn vào trang html 
    document.getElementById("categories").innerHTML=string;
}

showListCategories();

// chức năng thêm mới (Create)
function addNewCategory() {
    // lấy được nội dung ô input 
    let newName = document.getElementById("category_name").value;
    let descriptions = document.getElementById("description").value;
    // console.log(newName, descriptions);
    // tạo 1 đối tượng danh mục mới có 4 thuộc tính
    let newId = getNewId();
    let createdDate = new Date().toLocaleDateString();
    let newCategory = {
        id: newId,
        name: newName,
        descriptions: descriptions,
        createdDate: createdDate
    }
    // thêm mới vào mảng
    // categories.push(newCategory);
    categories= [...categories, newCategory];
    localStorage.setItem("categories", JSON.stringify(categories));
    // xáo dữ liệu 2 ô nhập vào
    document.getElementById("category_name").value ="";
    document.getElementById("description").value="";
    // cập nhật lại giao diện
    showListCategories();

}


// chức năng xóa (Delete)
function deleteCategory(idDelete){
    if(confirm("Bạn có chắc chắn muốn xóa không")){ 
    // lấy ra đc id cần xóa 
    let indexDelete = categories.findIndex((category)=>category.id==idDelete)
    // xóa theo splice
    categories.splice(indexDelete,1);
    localStorage.setItem("categories", JSON.stringify(categories));
    // cập nhật giao diện
    showListCategories();
    }
}

//Chức năng sửa (Update)
// phần 1 : lấy toàn bộ thông tin của danh mục cần sửa 
function getCategoryByid(id) {
    // lấy ra id 
    let indexEdit = categories.findIndex((cat)=>cat.id==id);
    // lấy đối tượng cần sửa
    let categoryEdit = categories[indexEdit];
    // đổ dũ liệu cuar đối tượng cần sửa ra form
    document.getElementById("category_id").value = categoryEdit.id;
    document.getElementById("category_name_edit").value = categoryEdit.name;
    document.getElementById("description_edit").value = categoryEdit.descriptions;
    document.getElementById("createdDate").value = categoryEdit.createdDate;

} 

// phần 2  : cập nhật lại thong tin sau khi chỉnh sửa
function updateCategory() {
     // lấy được nội dung ô input 
     let updateName = document.getElementById("category_name_edit").value;
     let updateDescriptions = document.getElementById("description_edit").value;
     let idEdit = document.getElementById("category_id").value;
     let createdDate = new Date().toLocaleDateString();
    //  lấy ra vị trí cần sửa
    let updateIndex = categories.findIndex((cat)=>cat.id == idEdit);
    // tiến hành sửa
    categories[updateIndex]={
        id: idEdit,
        name:updateName,
        descriptions: updateDescriptions,
        createdDate: createdDate
    } 
    localStorage.setItem("categories", JSON.stringify(categories));
     // cập nhật lại giao diện
     showListCategories();
 
}

// logic id tự tăng
function getNewId() {
    let idMax = 0;
    for (let i = 0; i < categories.length; i++) {
        const element = categories[i];
        if(idMax< element.id){
            idMax= element.id
        }
    }
    return idMax+1;
=======
// code logic của trang category

// let date = new Date();
// console.log(date.toLocaleDateString());

let categories = [
  {
    id: 1,
    name: "Category 1",
    descriptions:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
    createdDate: "28/10/2022",
  },
  {
    id: 2,
    name: "Category 2",
    descriptions:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
    createdDate: "28/10/2022",
  },
  {
    id: 3,
    name: "Category 3",
    descriptions:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
    createdDate: "28/10/2022",
  },
  {
    id: 4,
    name: "Category 4",
    descriptions:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
    createdDate: "28/10/2022",
  },
  {
    id: 5,
    name: "Category 5",
    descriptions:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
    createdDate: "28/10/2022",
  },
  {
    id: 6,
    name: "Category 6",
    descriptions:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
    createdDate: "28/10/2022",
  },
];

// chức năng hiển thị ra giao diện (READ)
function showListCategories() {
    let string ="";
    for (let i = 0; i < categories.length; i++) {
        const element = categories[i];
        string = string + `<tr>
        <td>${i+1}</td>
        <td>${element.name}</td>
        <td>${element.descriptions}
        </td>
        <td>${element.createdDate}</td>
        <td>
            <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#editModal"  onclick="getCategoryByid(${element.id})">Edit</button>
        </td>
        <td>
            <button type="button" class="btn btn-danger" onclick="deleteCategory(${element.id})">Delete</button>
        </td>
    </tr>`
    }

    // chèn vào trang html 
    document.getElementById("categories").innerHTML=string;
}

showListCategories();

// chức năng thêm mới (Create)
function addNewCategory() {
    // lấy được nội dung ô input 
    let newName = document.getElementById("category_name").value;
    let descriptions = document.getElementById("description").value;
    // console.log(newName, descriptions);
    // tạo 1 đối tượng danh mục mới có 4 thuộc tính
    let newId = getNewId();
    let createdDate = new Date().toLocaleDateString();
    let newCategory = {
        id: newId,
        name: newName,
        descriptions: descriptions,
        createdDate: createdDate
    }
    // thêm mới vào mảng
    categories.push(newCategory);
    // xáo dữ liệu 2 ô nhập vào
    document.getElementById("category_name").value ="";
    document.getElementById("description").value="";
    // cập nhật lại giao diện
    showListCategories();

}


// chức năng xóa (Delete)
function deleteCategory(idDelete){
    if(confirm("Bạn có chắc chắn muốn xóa không")){ 
    // lấy ra đc id cần xóa 
    let indexDelete = categories.findIndex((category)=>category.id==idDelete)
    // xóa theo splice
    categories.splice(indexDelete,1);
    // cập nhật giao diện
    showListCategories();
    }
}

//Chức năng sửa (Update)
// phần 1 : lấy toàn bộ thông tin của danh mục cần sửa 
function getCategoryByid(id) {
    // lấy ra id 
    let indexEdit = categories.findIndex((cat)=>cat.id==id);
    // lấy đối tượng cần sửa
    let categoryEdit = categories[indexEdit];
    // đổ dũ liệu cuar đối tượng cần sửa ra form
    document.getElementById("category_id").value = categoryEdit.id;
    document.getElementById("category_name_edit").value = categoryEdit.name;
    document.getElementById("description_edit").value = categoryEdit.descriptions;
    document.getElementById("createdDate").value = categoryEdit.createdDate;

} 

// phần 2  : cập nhật lại thong tin sau khi chỉnh sửa
function updateCategory() {
     // lấy được nội dung ô input 
     let updateName = document.getElementById("category_name_edit").value;
     let updateDescriptions = document.getElementById("description_edit").value;
     let idEdit = document.getElementById("category_id").value;
     let createdDate = new Date().toLocaleDateString();
    //  lấy ra vị trí cần sửa
    let updateIndex = categories.findIndex((cat)=>cat.id == idEdit);
    // tiến hành sửa
    categories[updateIndex]={
        id: idEdit,
        name:updateName,
        descriptions: updateDescriptions,
        createdDate: createdDate
    } 
     // cập nhật lại giao diện
     showListCategories();
 
}

// logic id tự tăng
function getNewId() {
    let idMax = 0;
    for (let i = 0; i < categories.length; i++) {
        const element = categories[i];
        if(idMax< element.id){
            idMax= element.id
        }
    }
    return idMax+1;
>>>>>>> ec29542e3b58de09fae1b5010409bd981c248138
}