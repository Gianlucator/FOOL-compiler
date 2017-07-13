push 0
push 5
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
lhp
push -2
lfp
add
lw
sop
lfp
lfp
push 0
smo
push Numero
js
push -2
lfp
add
lw
sop
lfp
lfp
push 1
smo
push Numero
js
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
push Numero
js
push -2
lfp
add
lw
sop
lfp
lfp
push 3
smo
push Numero
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
push -2
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
js

function0:
cfp
lra
push -2
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
