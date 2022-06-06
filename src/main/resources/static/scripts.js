//url относительно хоста. Можно поменять порт в application.properties и всё будет работать.
const url = './api/';


//Отправляет запрос для получения гифки.

// для получения гифки которая будет обраюатываться rest controller
function loadResultGif() {
    let code = $("#codesSelector").val(); //получает выбранный option из select`а.
    console.log(url + 'getgif/' + code);
    $.ajax({
        url: url + 'getgif/' + code,
        method: 'GET',
        dataType: "json",
        complete: function (data) {  // обработка ответа
            let content = JSON.parse(data.responseText);
            let img = document.createElement("img");
            img.src = content.data.images.original.url;
            let out = document.querySelector("#out");
            out.innerHTML = '';
            out.insertAdjacentElement("afterbegin", img);
        }
    })
}

//Заполняет select
function loadForSelect() {
    $.ajax({
        url: url + 'getcodes',
        method: 'GET',
        complete: function (data) {
            let codesList = JSON.parse(data.responseText);
            let select = document.querySelector("#codesSelector");
            select.innerHTML = '';
            for (let i = 0; i < codesList.length; i++) {
                let option = document.createElement("option");
                option.value = codesList[i];
                option.text = codesList[i];
                select.insertAdjacentElement("beforeend", option);
            }
        }
    })
}
