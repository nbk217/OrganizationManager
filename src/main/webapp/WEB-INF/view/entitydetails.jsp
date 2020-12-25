<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
${name}<br/>
<div class= "container">
<a type="button" class="btn btn-primary" href="/add-entity">Edit</a>
<a type="button" class="btn btn-primary" href="/groups">Groups</a>
<a type="button" class="btn btn-primary" href="/status">Status</a>
<a type="button" class="btn btn-primary" href="/chart">Chart</a>
</div>

<div class= "container">
<table class="table table-striped ">
    <caption><spring:message code="entity.caption"/></caption>
    <thead>
        <tr>
            <th>Legal Name</th>
            <th>Legal Address</th>
            <th>HeadQuarters Address</th>
            <th>Jurisdiction</th>
            <th>Form Of Organization</th>
            <th>Incorporation Date</th>
            <th>Status</th>
            <th>Notes</th>
        </tr>
    </thead>

    <tbody>
        <tr>
            <td>${entity.legalName} </td>
            <td>${entity.legalAddress} </td>
            <td>${entity.headquartersAddress} </td>
            <td>${entity.jurisdiction} </td>
            <td><fmt:formatDate pattern="dd/MM/yyyy"
				value="${entity.incorporationDate}" /></td>
			<td>${entity.status} </td>
		 </tr>
		 <tr></tr>
         <tr>
                <td><a  href="/update-entity?id=${entity.id}" class ="btn btn-info">Update</a></td>
                <td><a  href="/delete-entity?id=${entity.id}" class ="btn btn-danger">Delete</a></td>
                <td><a  href="/documents-entity?id=${entity.id}" class ="btn btn-secondary">Documents</a></td>
                <td><a  href="/add-requirement?id=1" class ="btn btn-secondary">Requirements</a></td>
                <td><a  href="/ownership?type=&active=" class ="btn btn-secondary">Ownership</a></td>
                <td><a  href="/people-entity?id=${entity.id}" class ="btn btn-secondary">People</a></td>
                <td><a  href="/alerts-entity?id=${entity.id}" class ="btn btn-secondary">Alerts</a></td>
                <td><a  href="/tasks-entity?id=${entity.id}" class ="btn btn-secondary">Tasks</a></td>
                <td><a  href="/notes-entity?id=${entity.id}" class ="btn btn-secondary">Notes</a></td>
          </tr>
    </tbody>

</table>

<div class="container">
<a type="button" class="btn btn-success" href="/add-entity">Add</a>
<a type="button" class="btn btn-primary" href="/add-entity">Active</a>
<a type="button" class="btn btn-primary" href="/add-entity">Inactive</a>
</div>
</div>
<%@ include file="common/footer.jspf"%>

