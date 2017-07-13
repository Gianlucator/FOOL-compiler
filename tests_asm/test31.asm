push 0
push function0
lfp
lfp
push -2
lfp
add
lw
js
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
js

Numero:
lmo
push 0
beq getNum6Numero6

getNum6Numero27:
cfp
lra
push -3
lop
add
lw
push 1
add
srv
sra
pop
sfp
lrv
lra
js

Numero2:
lmo
push 0
beq getNum6Numero27

function0:
cfp
lra
push 1
lhp
sw
push 1
lhp
add
shp
push Numero2
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
srv
sra
pop
sfp
lrv
lra
js
halt
