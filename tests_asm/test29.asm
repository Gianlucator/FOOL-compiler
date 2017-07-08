push 0
push 20
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
push 0
lhp
sw
push 1
lhp
add
shp
lhp
push -2
lfp
add
lw
sop
lfp
push 0
lfp
push get3Fabonicci9
js
print
halt

get3Fabonicci9:
cfp
lra
push 1
lfp
add
lw
push 20
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
lfp
push 1
lfp
add
lw
lfp
push foo3Fabonicci9
js
b label1
label0:
push 42
label1:
srv
sra
pop
pop
sfp
lrv
lra
js

foo3Fabonicci9:
cfp
lra
lfp
push 1
lfp
add
lw
push 1
add
lfp
push get3Fabonicci9
js
srv
sra
pop
pop
sfp
lrv
lra
js
halt
