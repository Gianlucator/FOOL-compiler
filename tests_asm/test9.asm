push 0
push 5
lhp
sw
push 1
lhp
add
shp
push Numero
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
lfp
push 0
smo
lop
push -2
add
lw
js
lop
sro
push -2
lfp
add
lw
sop
lfp
lfp
push 1
smo
lop
push -2
add
lw
js
lop
sro
push -2
lfp
add
lw
sop
lfp
push 10
lfp
push 2
smo
lop
push -2
add
lw
js
lop
sro
push -2
lfp
add
lw
sop
lfp
lfp
push 3
smo
lop
push -2
add
lw
js
add
add
add
print
halt

getX4Numero6:
cfp
lra
push 3
push -3
lop
add
lw
srv
pop
sra
pop
sfp
lrv
lra
lro
sop
js

getRedefinedX13Numero6:
cfp
lra
push 3
push -2
lfp
add
lw
srv
pop
sra
pop
sfp
lrv
lra
lro
sop
js

getParamX9Numero6:
cfp
lra
push 1
lfp
add
lw
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

function0:
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

getXInsideFun13Numero6:
cfp
lra
push function0
lfp
lfp
push -2
lfp
add
lw
js
srv
pop
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
beq getX4Numero6
lmo
push 1
beq getRedefinedX13Numero6
lmo
push 2
beq getParamX9Numero6
lmo
push 3
beq getXInsideFun13Numero6
halt
