<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
${name}<br/>

<div class= "container">
<table class="table table-striped ">
    <thead>
        <tr>
            <th></th>
            <th></th>
        </tr>
    </thead>

    <tbody>
        <tr>
          <td>
          <a type="button" class="btn btn-primary" href="/add-entity">Requirements</a>
          <a type="button" class="btn btn-primary" href="/groups">Annual Reports</a>
          <a type="button" class="btn btn-primary" href="/status">Other Requirements</a>
       </td>
       <td>
                <a type="button" class="btn btn-primary" href="/add-entity">Alerts</a>
                <a type="button" class="btn btn-primary" href="/groups">Tasks</a>
        </td>
   </tr>
   <tr>
                   <td>
                            Requirements by Jurisdiction
                   </td>
        <td>
                    <a type="button" class="btn btn-primary" href="/status">This Month</a>
                   <a type="button" class="btn btn-primary" href="/status">Next Month</a>
        </td>
       </tr>
       <tr>
               <td>
               <a type="button" class="btn btn-primary" href="/status">All</a>
                            <a type="button" class="btn btn-primary" href="/status">This Year</a>
                            <a type="button" class="btn btn-primary" href="/status">Next Year</a>
               </td>
               <td>
               <table class="table table-striped ">
                                  <thead>
                                     <tr>
                                       <th> Alert Date</th>
                                     </tr>
                                  </thead>
                                     <tbody>
                                        <c:forEach items="${entities}" var="entity">
                                          <tr>
                                               <td><fmt:formatDate pattern="MM/dd/yyyy"
                                                  value="${entity.alertDate}" /></td>
                                          </tr>
                                        </c:forEach>
                                     </tbody>
                                 </table>
               </td>
       </tr>
  </tbody>
</table>
</div>

<%@ include file="common/footer.jspf"%>

