function ShowLoginText(){
    layer.open({
        type:1,
        title:"��¼",
        area:["395px","300px"],
        content:$("#loginBox"),
        });
    }
function Login(){
    var username=$.trim($("#InputUsername").val());//��ȡ�û���trim��ȥ���ո�
    var password=$.trim($("#InputUserPwd").val());//��ȡ����
    if(username==""||password==""){
        layer.alert("�û����������벻��Ϊ��!",{
        title:"��ʾ",
        icon:5, 
        });
    }
}