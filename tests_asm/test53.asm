push 0
push 2
push 1
beq label5
push 0
b label6
label5:
push 1
label6:
push 1
beq label3
push C
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
b label4
label3:
push B
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
label4:
push 73
print
halt

f1A1:
cfp
lra
push 44
srv
sra
pop
sfp
lrv
lra
lro
sop
js

A:
lmo
push 0
beq f1A1

C:
lmo
push 0
beq f1A1

B:
lmo
push 0
beq f1A1
halt
