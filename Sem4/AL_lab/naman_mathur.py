def get_max_string(a,b):
	if len(a)>len(b):
		return len(a)
	else:
		return len(b)


s= get_max_string("abc","heheheh")
print(s)






def get_max_string2(a,b):
	new_len=[]
	for i,j in zip(a,b):
		if len(i)>len(j):
			new_len.append(len(i))
		else:
		    new_len.append(len(j))

	return new_len


a=["abc","mnqpp","lalu"]
b=["mooo","oo","aaaaaa"]
s= get_max_string2(a,b)
print(s)


