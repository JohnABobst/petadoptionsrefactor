import React, { useState } from "react"
import _ from "lodash";

const PetAdoptionsForm = props => {
  const [adoptionForm, setAdoptionForm] = useState({
      name: '',
      phoneNumber: '',
      email: '',
      homeStatus: ''
  })

  let requiredFields = {
    name : "Name",
    phoneNumber : "Phone number",
    email : "Email",
    homeStatus : "Home status",
  }
  const [errors, setErrors] = useState({})

  const handleChange=(event) => {
    setAdoptionForm({
      ...adoptionForm, 
      [event.target.name] : event.target.value
    })
  }

  const handleClose = () => {
    props.setDisplayForm(false)
  }

  const handleSubmit = (event) => {
    event.preventDefault()
    let formErrors = {}
    for (let field of Object.keys(requiredFields)) {
      if (adoptionForm[field].trim() === "") {
        formErrors = {
          ...formErrors,
          [field] : `${requiredFields[field]} cannot be blank.`
        }
      }
    }
    setErrors(formErrors)
    if (_.isEmpty(errors)) {
      fetch(`/api/v1/petadoptions/${props.pet_id}`, {
        method:"POST",
        body: JSON.stringify(adoptionForm),
        headers: {"Content-Type" : "application/json"}
      })
      .then(result => {
        setAdoptionForm({
          name: '',
          phoneNumber: '',
          email: '',
          homeStatus: '',
      })
        props.setApplicationStatus("Your request is in process")
        handleClose()
      })
    } 
  }

  return(
    <>
      <button onClick={handleClose}>Close</button>
      <form id="column-form" onSubmit={handleSubmit}>
        <label>Name
          <p className="error">{errors.name}</p>
          <input onChange={handleChange} type="text" name="name" id="name" value={adoptionForm.name} />
        </label>
        <label>Phone Number
          <p className="error">{errors.phone_number}</p>
          <input onChange={handleChange} type="text" name="phoneNumber" id="phone_number" value={adoptionForm.phone_number} />
        </label>
        <label>Email
          <p className="error">{errors.email}</p>
          <input onChange={handleChange} type="text" name="email" id="email" value={adoptionForm.email} />
        </label>
        <label>Home Status
          <p className="error">{errors.home_status}</p>
          <select onChange={handleChange} type="text" name="homeStatus" id="home_status" value={adoptionForm.home_status}>
            <option value=""></option>
            <option value="Rent">Rent</option>
            <option value="Own">Own</option>
          </select>
        </label>
        <input type="submit" value="submit" />
      </form>
    </>
  )
}

export default PetAdoptionsForm