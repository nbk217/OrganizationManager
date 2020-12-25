<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
Hi ${name}<br/>
<div class= "container">
<a type="button" class="btn btn-primary" href="/add-entity">Edit Profile</a>
<a type="button" class="btn btn-primary" href="/groups">Email Preferences</a>
<a type="button" class="btn btn-primary" href="/status">Change Password</a>
</div>

<div class= "container">
<table class="table table-striped ">
    <caption><spring:message code="entity.caption"/></caption>
    <thead>
            <tr>
                <th></th>
                <th></th>
            </tr>
        </thead>
    <tbody>
        <tr>
            <td>Name: ${entity.legalName} </td>
            <td>Groups: ${entity.groups} </td>
        </tr>
        <tr>
            <td>Email: ${entity.legalName} </td>
            <td>Document Access? ${entity.status} </td>
        </tr>
        <tr>
            <td>User Roles: ${entity.legalName} </td>
            <td>Task Reminders? ${entity.status} </td>
        </tr>
    </tbody>

</table>
</div>
<%@ include file="common/footer.jspf"%>

