<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
${name}<br/>
<div class= "container">

<table class="table table-striped ">
    <caption><spring:message code="entity.caption"/></caption>
    <thead>
        <tr>
            <th>Legal Name</th>
            <th>Jurisdiction</th>
            <th>Form of Organization</th>
            <th>Incorporation Date</th>
            <th>Status</th>
            <th>Last Updated</th>
        </tr>
    </thead>

    <tbody>
    <c:forEach items="${entities}" var="entity">

        <tr>
            <td><a href="/entitydetails?id=${entity.id}">${entity.legalName}</a></td>
            <td>${entity.jurisdiction} </td>
            <td>${entity.formOfOrganization} </td>
            <td><fmt:formatDate pattern="MM/dd/yyyy"
				value="${entity.incorporationDate}" /></td>
			<td>${entity.status} </td>
            <td><fmt:formatDate pattern="MM/dd/yyyy"
				value="${entity.lastUpdated}" /></td>
            <td><a  href="/update-entity?id=${entity.id}" class ="btn btn-info">Update</a></td>
            <td><a  href="/delete-entity?id=${entity.id}" class ="btn btn-danger">Delete</a></td>
        </tr>

    </c:forEach>
    </tbody>

</table>

<div>
<a type="button" class="btn btn-success" href="/add-entity">Add</a>
<a type="button" class="btn btn-primary" href="/add-entity">Active</a>
<a type="button" class="btn btn-secondary" href="/add-entity">Inactive</a>
</div>
</div>
<%@ include file="common/footer.jspf"%>

