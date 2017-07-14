push 0
push function0
lfp
lfp
push -2
lfp
add
lw
js
lop
sro
push -3
lfp
add
lw
sop
lfp
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

getNum6Numero6:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
sfp
lrv
lra
lro
sop
js

Numero:
lmo
push 0
beq getNum6Numero6

function0:
cfp
lra
push 1
lhp
push 0
add
sw
push Numero
lhp
push 1
add
sw
push 3
lhp
push 2
add
sw
lhp
push 3
add
shp
lhp
srv
sra
pop
sfp
lrv
lra
js
halt
