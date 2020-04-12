function formCreate(id,obj) {
    var body = document.body;
    var form = document.createElement("form");
    form.setAttribute("id",id);
    form.setAttribute("action",obj.url);
    form.setAttribute("method",obj.method);
    form.style.display = "none";
    if (obj.enctype !== undefined){
        form.setAttribute("enctype",obj.enctype);
    }
    if(obj.text !== undefined){
        var list = obj.text;
        console.log(list);
        for(i in list){
            createInput(i,"text",list[i]);
        }
    }
    if(obj.hidden !== undefined){
        var pp = obj.hidden;
        createInput("_method","hidden",pp);
    }
    body.appendChild(form);
    if (obj.submit){
        form.submit();
    }

    function createInput(name,type,value) {
        var input = document.createElement("input");
        input.setAttribute("name",name);
        input.setAttribute("type",type);
        input.setAttribute("value",value);
        form.appendChild(input);
    }
};