<#import "parts/common.ftl" as c> <@c.page>
<#if !time??>
<div>
<h3>The program multiplies two squared matrices</h3>
</div>
<br/>
<div class="form-group mt-3">
	
	<form method="post" enctype="multipart/form-data">
		<div class="input-group">
		
			<div class="form-group">
			 	<input type="number" class="form-control" id="size" placeholder="Enter matrices size" name = "size" min=2 required>
				</div>

		</div>
		<br/>
		<div class="form-group">
			<button type="submit" class="btn btn-info">Multiply</button>
		</div>

	</form>
</div>
</#if>

<#if time??>
<form>
<ul class="list-group">
  <li class="list-group-item active">Estimated time for multiply SYNC two 2D matrices of square size (${size}):</li>
  <li class="list-group-item">${time} miliseconds</li>
</ul>

<ul class="list-group">
  <li class="list-group-item active">Estimated time for multiply ASYNC1 two 2D matrices of square size (${size}):</li>
  <li class="list-group-item">${time1} miliseconds</li>
</ul>

<ul class="list-group">
  <li class="list-group-item active">Estimated time for multiply ASYNC2 two 2D matrices of square size (${size}):</li>
  <li class="list-group-item">${time2} miliseconds</li>
</ul>

<ul class="list-group">
  <li class="list-group-item">${message}</li>
</ul>
</form>
</#if>
</@c.page>