push 0
push function1
push function2
push 8
push function3
push function4
push 0
nullnullprint
halt

function0:
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
pop
sfp
lrv
lra
js

function2:
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

function3:
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

function4:
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
