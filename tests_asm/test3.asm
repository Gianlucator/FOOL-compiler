push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 1
lhp
sw
push 1
lhp
add
shp
push 1
push -2
lfp
add
lw
label4:
push 0
lhp
push -1
add
bleq label5
lhp
push -1
add
lw
push -2
lfp
add
lw
beq label3
lhp
lhp
push -2
add
lw
sub
shp
b label4
label3:
lhp
label5:
push uA
lw
js
print
halt

uA:
cfp
lra
push 1
srv
sra
pop
pop
sfp
lrv
lra
js

sB:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js
