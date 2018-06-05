$(document).ready(function () {
    $.ajax({
        url: "/user/authconfig/getAllPermission",
        async: false,
        type: "get",
        success:function (data) {
            if(data != null){
                var dataObj = JSON.parse(data);
                if(dataObj.status == 1){
                    var dataarray = dataObj.data;
                    var obj = document.getElementById("pro-main");
                    obj.innerHTML = "<ul>\n";
                    for(x in dataarray){
                        obj.innerHTML += "<li>"+dataarray[x]+"</li>\n";
                    }
                    obj.innerHTML += "</ul>";
                }
            }
        },
    });
});

