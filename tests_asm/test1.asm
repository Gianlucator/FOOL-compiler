push 0
push 20
lhp
sw
push 1
lhp
add
shp
push Fabonicci
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
lhp
lhp
sop
lop
sro
push -2
lfp
add
lw
sop
lfp
push 0
lfp
push 0
smo
lop
push -2
add
lw
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
lop
sro
lfp
push 1
lfp
add
lw
lfp
push 1
smo
lop
push -2
add
lw
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
lro
sop
js

foo3Fabonicci9:
cfp
lra
lop
sro
lfp
push 1
lfp
add
lw
push 1
add
lfp
push 0
smo
lop
push -2
add
lw
js
srv
sra
pop
pop
sfp
lrv
lra
lro
sop
js

Fabonicci:
lmo
push 0
beq get3Fabonicci9
lmo
push 1
beq foo3Fabonicci9
halt
