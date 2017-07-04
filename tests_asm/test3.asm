push function4
push function5
push function6
push function7
push 0
lhp
push 66
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
nullprint
halt

function0:
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

function1:
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
sfp
lrv
lra
js

function2:
cfp
lra
push 5
lfp
lfp
push -2
lfp
add
lw
lfp
lw
push -4
lfp
lw
add
lw
js
lfp
lw
push -3
lfp
lw
add
lw
js
srv
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js

function3:
cfp
lra
push -1
lfp
lw
add
lw
push -2
lfp
lw
add
lw
mult
srv
sra
pop
pop
sfp
lrv
lra
js

function4:
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

function5:
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

function6:
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

function7:
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
