import React, { useState } from 'react';
import { Contact } from '../types';

interface ContactModalProps {
  isOpen: boolean;
  onClose: () => void;
  onSave: (contact: Omit<Contact, 'id'>) => void;
}

const ContactModal: React.FC<ContactModalProps> = ({ isOpen, onClose, onSave }) => {
  const [formData, setFormData] = useState({
    type: 'Phone' as Contact['type'],
    value: '',
    isPrimary: false,
  });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSave(formData);
    setFormData({
      type: 'Phone',
      value: '',
      isPrimary: false,
    });
    onClose();
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value, type } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: type === 'checkbox' ? (e.target as HTMLInputElement).checked : value
    }));
  };

  if (!isOpen) return null;

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal-content" onClick={(e) => e.stopPropagation()}>
        <div className="modal-header">
          <h2>Create New Contact</h2>
          <button className="close-button" onClick={onClose}>×</button>
        </div>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="type">Type:</label>
            <select
              id="type"
              name="type"
              value={formData.type}
              onChange={handleChange}
              required
            >
              <option value="Phone">Phone</option>
              <option value="Email">Email</option>
              <option value="Fax">Fax</option>
              <option value="Other">Other</option>
            </select>
          </div>
          <div className="form-group">
            <label htmlFor="value">Value:</label>
            <input
              type={formData.type === 'Email' ? 'email' : 'text'}
              id="value"
              name="value"
              value={formData.value}
              onChange={handleChange}
              placeholder={
                formData.type === 'Phone' ? 'e.g., +1-555-123-4567' :
                formData.type === 'Email' ? 'e.g., john@example.com' :
                'Enter contact value'
              }
              required
            />
          </div>
          <div className="form-group checkbox-group">
            <label htmlFor="isPrimary">
              <input
                type="checkbox"
                id="isPrimary"
                name="isPrimary"
                checked={formData.isPrimary}
                onChange={handleChange}
              />
              Set as primary contact
            </label>
          </div>
          <div className="modal-actions">
            <button type="button" onClick={onClose} className="cancel-button">
              Cancel
            </button>
            <button type="submit" className="save-button">
              Save Contact
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ContactModal;