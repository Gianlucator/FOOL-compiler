push 0
push 5
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
lfp
push getX4Numero6
js
push -2
lfp
add
lw
sop
lfp
lfp
push getRedefinedX13Numero6
js
push -2
lfp
add
lw
sop
lfp
push 10
lfp
push getParamX9Numero6
js
push -2
lfp
add
lw
sop
lfp
lfp
push getXInsideFun13Numero6
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
js
halt
