<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class= "container">
<a type="button" class="btn btn-primary" href="/add-ownership">Add</a><br/><br/>
<a type="button" class="btn btn-primary" href="/ownership?type=Parent&active=true">Active</a>
<a type="button" class="btn btn-primary" href="/ownership?type=Parent&active=false">Inactive</a>
</div>

<div class= "container">
<table class="table table-striped ">
    <caption><spring:message code="ownership.caption"/></caption>
    <thead>
        <tr>
            <th>Parent</th>
            <th>%Ownership</th>
            <th>Acquisition Date</th>
            <th>Last Updated</th>
        </tr>

    </thead>

    <tbody>
    <c:forEach items="${ownerships}" var="ownership">
        <c:if test="${ownership.type eq 'Parent'}">
        <tr>
            <td>${ownership.entity.legalName} </td>
            <td>${ownership.percentage} </td>
            <td><fmt:formatDate pattern="MM/dd/yyyy"
				value="${ownership.acquisitionDate}" /></td>
			<td>${ownership.lastUpdated} </td>
		 </tr>
	    </c:if>
     </c:forEach>
    </tbody>

</table>

</div>
<div class= "container">
<a type="button" class="btn btn-primary" href="/ownership?type=Subsidiary&active=true">Active</a>
<a type="button" class="btn btn-primary" href="/ownership?type=Subsidiary&active=false">Inactive</a>

<table class="table table-striped ">
    <caption><spring:message code="entity.caption"/></caption>
     <thead>
            <tr>
                <th>Subsidiary</th>
                <th>%Ownership</th>
                <th>Acquisition Date</th>
                <th>Last Updated</th>
            </tr>
     </thead>

    <tbody>
        <c:forEach items="${ownerships}" var="ownership">
          <c:if test="${ownership.type eq 'Subsidiary'}">
            <tr>
                <td>${ownership.entity.legalName} </td>
                <td>${ownership.percentage} </td>
                <td><fmt:formatDate pattern="MM/dd/yyyy"
                    value="${ownership.acquisitionDate}" /></td>
                <td>${ownership.lastUpdated} </td>
             </tr>
          </c:if>
	    </c:forEach>

    </tbody>

</table>
</div>
<%@ include file="common/footer.jspf"%>

