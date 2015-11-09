<%@ include file="init.jsp" %>

<div class="homePage">
	<div class="support">
		<span class="wtsappImg">
			<img class="appImg" src="<%=request.getContextPath() %>/images/wtsapp.png" />
		</span>
		<span class="wtsappNum">
			8886080212
		</span>
	</div>
	<div class="busTopMessage">
		Booking a Bus just got Easier
	</div>
	<div class="busImage">
		<img src="<%=request.getContextPath() %>/images/bus.png" />
	</div>
	<div class="busBookMessage">
		<a href="reservation">Book Now</a>
	</div>
</div>
<style>
	.homePage{
		text-align:center;
		font-style:solid;
		font-size:25px;
		font-family:"Comic Sans MS", cursive, sans-serif;
	}
	.busImage{
		margin:10px;
		padding:10px;
	}
	.busTopMessage{
		margin:5px;
		padding:20px;
		color:#669900;
	}
	.busBookMessage{
		margin:5px;
		padding:20px;
	}
	.support{
		text-align:right;
		margin:5px;
		padding:5px;
	}
	.wtsappNum{
		font-size:15px;
		font-family:"Comic Sans MS", cursive, sans-serif;
		color:#2F4F4F;
	}
	.appImg{
		width:40px;
	}
</style>
