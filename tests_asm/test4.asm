push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 2
lhp
sw
push 1
lhp
add
shp
push 2
push -2
lfp
add
lw
label7:
push 0
lhp
push -1
add
bleq label8
lhp
push -1
add
lw
push -2
lfp
add
lw
beq label6
lhp
lhp
push -2
add
lw
sub
shp
b label7
label6:
lhp
label8:
push uB
lw
js
print
halt

uA:
cfp
lra
push 2
srv
sra
pop
pop
sfp
lrv
lra
js

uB:
cfp
lra
push 0
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
push 3
srv
sra
pop
pop
sfp
lrv
lra
js
